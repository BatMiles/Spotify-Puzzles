#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <math.h>
 
int reverse(int n)
{
  int  bitCount = sizeof(n) * 8;
  int  reverseBits = 0, 
  		i = 0, 
  		maskBit = 1, 
  		shiftCount = 0;

  for (; i < bitCount; ++i)
  {
    maskBit = (n & 1);
    if (maskBit) 
    {
      reverseBits <<= shiftCount;
      reverseBits |= maskBit;
      shiftCount = 1;
    } else {  
      shiftCount++;
    }
    n >>= 1;
  }

  return reverseBits;
}

 int main(int argc, char* argv[]){
     int begin;
     scanf("%d", &begin);

     if(1>begin || begin>1000000000){
                 return -1;
     }

     int end = reverse(begin);
     printf("%d\n", end);
            return 0;
 }