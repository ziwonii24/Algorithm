#include <bits/stdc++.h>
using namespace std;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
	cout.tie(0);
}

typedef long long ll;
const int MAX = 1000000;
int n, a[MAX + 1], b, c, cnt[MAX + 1];
ll ans;

int main() {
	init();
	cin >> n;
	for (int i = 0; i < n; i++)
		cin >> a[i];
	cin >> b >> c;

	for (int i = 0; i < n; i++) {
		if (a[i] - b <= 0) //총감독관 하나면 되는 경우
			cnt[i] = 1;
		else {	//부감독관이 필요한 경우
			cnt[i] = 1;
			a[i] -= b;

			if (a[i] % c == 0) cnt[i] += a[i] / c;
			else cnt[i] += a[i] / c + 1;
		}

		ans += cnt[i];
	}
	cout << ans;
	return 0;
}
