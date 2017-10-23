
// Multiply list
 List<Integer> original  = Arrays.asList(1,2,3);
        List<Integer> output = original
                .stream()
                .map(num -> num *2)
                .collect(Collectors.toList());
        System.out.println(output);




// Read file
private String readFile(String fileName) {

    File file = new File(fileName);

    char[] buffer = null;

    try {
        BufferedReader bufferedReader = new BufferedReader(
                new FileReader(file));

        buffer = new char[(int)file.length()];

        int i = 0;
        int c = bufferedReader.read();

        while (c != -1) {
            buffer[i++] = (char)c;
            c = bufferedReader.read();
        }
    } catch (FileNotFoundException e) {
        log.error(e.getMessage());
    } catch (IOException e) {
        log.error(e.getMessage());
    }

    return new String(buffer);
}