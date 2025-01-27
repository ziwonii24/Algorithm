#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int main() {
	int cnt = 0;
	string s;
	getline(cin, s);

	for (int i = 0; i < s.size(); i++) {
		if (s[i] == ' ') cnt++;

		if (i == 0 && s[i] == ' ') cnt--;
		if (i == s.size() - 1 && s[i] == ' ') cnt--;
	}

	cout << cnt+1 << '\n';

	return 0;
}
