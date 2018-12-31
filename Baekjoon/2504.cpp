#include <iostream>
#include <stack>
#include <cstring>
#include <string>
using namespace std;

string s;
stack<char> stk;
int ans = 0, k = 0, l = 0, mul = 1;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> s;
	
	for (int i = 0; i < s.length(); i++) {
		char now = s[i];
		switch (now) {
		case '(':
			++k;
			stk.push(now);
			mul *= 2;
			if (i + 1 < s.length() && s[i + 1] == ')') ans += mul;
			break;
		case '[':
			++l;
			stk.push(now);
			mul *= 3;
			if (i + 1 < s.length() && s[i + 1] == ']') ans += mul;
			break;
		case ')':
			if (k > 0) {
				--k;
				stk.pop();
				mul /= 2;
			}
			else {
				cout << 0 << '\n';
				return 0;
			}
			break;
		case ']':
			if (l > 0) {
				--l;
				stk.pop();
				mul /= 3;
			}
			else {
				cout << 0 << '\n';
				return 0;
			}
			break;
		}
	}

	if (!stk.empty() || l != 0 || k != 0)
		cout << 0 << '\n';
	else
		cout << ans << '\n';

	return 0;
}
