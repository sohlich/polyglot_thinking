package main

import (
	"bufio"
	"fmt"
	"log"
	"os"
	"strings"
	"sync"
)

func main() {
	log.Printf("Application %s starting.", "Word Count")
	f, _ := os.Open("data.txt")
	defer f.Close()
	scanner := bufio.NewScanner(f)
	scanner.Split(bufio.ScanLines)

	//Communication channel
	cChan := make(chan int)
	// Signaling channels
	countStop := make(chan bool)

	var wait = new(sync.WaitGroup)
	cnt := 0
	go func(c chan int, stopChan chan bool) {
		for {
			select {
			case len := <-c:
				cnt = cnt + len
			case <-stopChan:
				return
			}
		}
	}(cChan, countStop)

	goroutineCnt := 0
	for scanner.Scan() {
		wait.Add(1)
		goroutineCnt++
		go func(s string) {
			cChan <- len(strings.Split(s, " "))
			wait.Done()
		}(scanner.Text())
	}

	wait.Wait()
	close(countStop)

	fmt.Printf("Total count word count:%d counted by %d goroutines\n", cnt, goroutineCnt)
}
