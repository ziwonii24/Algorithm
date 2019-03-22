#include <iostream>
#include <algorithm>
#include <vector>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

const int MAX = 10;
int n;
int arr[MAX][MAX];

void sol() {
  //마저 진행하기!!!



	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++)
			cout << arr[i][j] << ' ';
		cout << '\n';
	}
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		cin >> n;
		cout << '#' << T << '\n';
		sol();
		cout << '\n';
	}
	return 0;
}
