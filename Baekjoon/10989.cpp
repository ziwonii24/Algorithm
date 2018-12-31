#include <iostream>
#include <cstdio>
#include <algorithm>
#include <string>
#include <cstring>
using namespace std;

int n;
int d[10001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		int tmp;
		cin >> tmp;
		d[tmp]++;
	}

	for (int i = 1; i <= 10000; i++) {
		for (int j = 0; j < d[i]; j++) {
			cout << i << '\n';
		}
	}

	return 0;
}
