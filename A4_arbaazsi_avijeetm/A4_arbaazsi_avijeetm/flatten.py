

2.a) We cannot use the given ML language 'Flatten' Function for 2-level or 3-level lists because,
flatten function is of type 'a list list -> 'a list. so, if there are nested lists, the types will mismatch,
since this function is not recursive. So we will not be able to ever access the base list to retrieve the elements.

However, in SML, we can create our own list type instead of using the default list type, which will enable us to 
access nested lists and therefore, use recursion to solve this problem.

2.b)

l=[];
    
def flatten(f):
        for item in f:
            if type(item)==type(f):
                flatten(item);
            if type(item)==type(int()):
                l.append(item);

				
input=[[[1],[2]],[[3]],[[4,5],[6]]];				
flatten(input);

for number in l:
    print number;