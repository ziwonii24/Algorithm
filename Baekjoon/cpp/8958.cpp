#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int tc;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> tc;
	while (tc--) {
		string s;
		cin >> s;
		int cnt = 0, sum = 0;
		for (int i = 0; i < s.size(); i++) {
			if (s[i] == 'O') cnt++;
			else cnt = 0;

			sum += cnt;
		}

		cout << sum << '\n';
	}

	return 0;
}
