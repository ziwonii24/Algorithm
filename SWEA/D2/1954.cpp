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
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			arr[i][j] = 0;

	for (int i = 0; i <= n + 1; i++) {
		arr[0][i] = -1;
		arr[i][0] = -1;
		arr[n + 1][i] = -1;
		arr[i][n + 1] = -1;
	}

	int r = 1, c = 0, d = 2;
	for (int i = 1; i <= n * n; i++) {
		if (d == 0 && arr[r + 1][c] != 0) d = 1;
		if (d == 1 && arr[r][c - 1] != 0) d = 3;
		if (d == 2 && arr[r][c + 1] != 0) d = 0;
		if (d == 3 && arr[r - 1][c] != 0) d = 2;

		if (d == 0) r++;
		else if (d == 1) c--;
		else if (d == 2) c++;
		else if (d == 3) r--;

		arr[r][c] = i;
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
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++)
				cout << arr[i][j] << ' ';
			cout << '\n';
		}
	}
	return 0;
}
