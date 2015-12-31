Control.Print.printDepth := 1000;
datatype 'a ntree = leaf of 'a | node of 'a ntree list;	
	
fun map(f, [ ]) = [ ]
| map(f, x::t) = f(x) :: map(f, t);
	fun subst(leaf(x),v1,v2) = if x = v1 then leaf(v2)
								else leaf(x)
   | subst(node(l),v1,v2) = let fun h(x) = subst(x,v1,v2);
			 in node(map(h,l))
			end;

fun reduce(f, b, [ ]) = b
| reduce(f, b, x::t) = f(x, reduce(f, b, t));
	fun toString(leaf(x)) = x
   | toString(node(l)) = let fun h(x, y) = toString(x)^""^y;
			 in reduce(h,"", l)
			end;