Program Lesson1_Program3;
Var       
    Num1, Num2, Sum : Integer;

Begin {no semicolon}
	Writeln('Input number 1:'); 
	Readln(Num1);
	Writeln('Input number 2:');
	Readln(Num2);
	Sum := Num1 + Num2; {addition} 
	Writeln("Result of sum is:");
	Writeln(Sum);
	Readln;
End.   