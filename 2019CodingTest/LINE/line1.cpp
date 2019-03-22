#include <iostream>
#include <algorithm>
#include <cmath>
using namespace std;
typedef long long ll;

void init() {
	ios::sync_with_stdio(0);
	cin.tie(0);
}

int main(void) {
    init();
	ll n;
	cin >> n;
    if (n == 1) {
		cout << 0;
		return 0;
	}
	ll tmp = n, ans = n;
	for (ll i = 1; i <= n; i++) {
		if (tmp == i) break;
		if (n%i == 0) {
			tmp = n / i;
			ans = min(ans, abs(tmp - i));
			if (ans == 0) break;
		}
	}
	cout << ans;
    return 0;
}