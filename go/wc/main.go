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

	ch := make(chan string)
	cChan := make(chan int)

	// Signaling channels
	stopChan := make(chan bool)
	countStop := make(chan bool)

	var wait = new(sync.WaitGroup)
	for i := 0; i < 10; i++ {
		wait.Add(1)
		go func(ch <-chan string, countChan chan int, id int) {
			defer wait.Done()
			for {
				select {
				case s := <-ch:
					fmt.Printf("%d :Received %s\n", id, s)
					cChan <- len(strings.Split(s, " "))
				case <-stopChan:
					fmt.Printf("%d : Stopping\n", id)
					return
				}
			}
		}(ch, cChan, i)
	}

	cnt := 0
	go func(c chan int, stopChan chan bool) {
		for {
			select {
			case len := <-c:
				fmt.Printf("Counting %d\n", len)
				cnt = cnt + len
			case <-countStop:
				fmt.Printf("Counting stopped\n")
				return
			}
		}
	}(cChan, stopChan)

	for scanner.Scan() {
		wait.Add(1)
		go func(s string) {
			ch <- s
			wait.Done()
		}(scanner.Text())
	}

	close(stopChan)
	wait.Wait()
	close(countStop)

	fmt.Printf("Total count %d\n", cnt)
}
