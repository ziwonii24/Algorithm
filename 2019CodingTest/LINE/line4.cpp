#include <iostream>
#include <algorithm>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

const int mx = 1000002;
int n;
int val[mx], ans[mx];

int main() {
	init();
	cin >> n;
	for (int i = 1; i <= n; i++)
		cin >> val[i];

	int tmp = -1;
	for (int i = 1; i <= n; i++) {
		for (int j = i + 1; j <= n; j++) {
			if (val[i] < val[j]) {
				ans[i] = max(ans[i], j - i);
				tmp = -1;
				break;
			}
			else if (val[i] == val[j]) {
				ans[i] = max(ans[i], j - i);
				ans[j] = max(ans[j], j - i);
				tmp = -1;
				break;
			}
			else if (val[i] > val[j]) {
				if (tmp == -1) {
					tmp = val[j];
					ans[j] = max(ans[j], j - i);
				}
				else {
					if (tmp < val[j]) {
						ans[j] = max(ans[j], j - i);
						tmp = val[j];
					}
				}
			}
		}
	}

	int result = 0;
	for (int i = 1; i <= n; i++)
		result = max(result, ans[i]);
	cout << result;

	return 0;
}