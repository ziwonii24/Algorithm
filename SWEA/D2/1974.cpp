#include <iostream>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int board[9][9];

int check() {
	for (int i = 0; i < 9; i++) {
		int vsum = 0, hsum = 0;
		for (int j = 0; j < 9; j++) {
			vsum += board[i][j];
			hsum += board[j][i];
		}

		if (vsum != 45) return 0;
		if (hsum != 45) return 0;
	}

	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			int sum = 0;
			for (int u = 0; u < 3; u++) {
				for (int v = 0; v < 3; v++) {
					sum += board[i * 3 + u][j * 3 + v];
				}
			}
			if (sum != 45) return 0;
		}
	}

	return 1;
}

int main() {
	init();
	int tc;
	cin >> tc;
	for (int T = 1; T <= tc; T++) {
		for (int i = 0; i < 9; i++)
			for (int j = 0; j < 9; j++)
				cin >> board[i][j];
		cout << '#' << T << ' ' << check() << '\n';
	}
	return 0;
}
