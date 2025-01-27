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

	int d[9];
	for (int i = 0; i < 8; i++)
		cin >> d[i];

	int asc = 0, des = 0, mix = 0;

	for (int i = 0; i < 8; i++) {
		if (d[i] == i + 1)
			asc++;
		else if (d[i] == 8 - i)
			des++;
		else
			mix++;
	}

	if(asc==8)
		cout << "ascending\n";
	else if(des==8)
		cout << "descending\n";
	else
		cout << "mixed\n";

	return 0;
}
