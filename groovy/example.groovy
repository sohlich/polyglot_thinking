println ""
println "### Collect on list ###"
def b = [1, 2, 3].collect { it * 2 }; 
println "Result:"+b;


println ""
println "### Example maximum list ###"
def list = [9, 4, 2, 10, 5]
println "Max:"+list.max()
println "Min:"+list.min()

println ""
println "### Reading file ###"
def input = new File("example.txt");
println input.text

println ""
println "### Easy access to maps ###"
def map = [name: 'Gromit', likes: 'cheese', id: 1234]
println map.name