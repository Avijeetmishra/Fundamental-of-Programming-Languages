int i,j,l;



thunk3()
{
int temp3=j*l-i;
return temp3;
}

thunk2()
{
int temp2=(i+j)*sigma(&l,0,4,thunk3);
return temp2;
}




thunk1()
{
int temp1=i*sigma(&j,0,4,thunk2);
return temp1;
}



int sigma(int *k, int low, int high, int expr()) { 
    int sum = 0;     for (*k=low; *k<=high; (*k)++) {
         sum = sum + expr();
}
return sum;
}

void main(){

int c=sigma(&i,0,4,thunk1);
printf("%d\n",c);

}

