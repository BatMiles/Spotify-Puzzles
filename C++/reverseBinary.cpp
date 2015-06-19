#include <iostream>
#include <math.h>
#include <string>
#include <algorithm>

using namespace std;

int reverse(int source){
	std::string binary;
	while(source!=0) {
		binary=(source%2==0 ?"0":"1")+binary; 
		source/=2;
	}	
	
	reverse(binary.begin(), binary.end());
	
	int output = 0, pow = 1;
	
    for ( int i = binary.length() - 1; i >= 0; --i, pow <<= 1 ){
        output += (binary[i] - '0') * pow;
    }

	return output; 
}	

int main() {
	int num;
	if(0>num || num>1000000000){
		exit(EXIT_FAILURE);
	}
	cin >> num;
	cout<< reverse(num)<<endl;
}