#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int d[6];
	int sum=0;
	for (int i = 0; i < 5; i++) {
		cin >> d[i];
		if (d[i] < 40)
			d[i] = 40;
		sum += d[i];
	}

	printf("%d\n", sum / 5);


	return 0;
}
