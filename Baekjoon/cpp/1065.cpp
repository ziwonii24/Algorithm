#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int n, diff, cnt=0;
string sn;

void fn(int m) {
	if (m < 100)
		cnt++;
	else {
		sn = to_string(m);
		diff = sn[1] - sn[0];
		for (int i = 1; i < sn.size() - 1; i++) {
			if (diff == sn[i + 1] - sn[i])
				cnt++;
		}
	}
}

int main() {
	cin >> n;

	for (int i = 1; i <= n; i++)
		fn(i);	

	cout << cnt << '\n';

	return 0;
}