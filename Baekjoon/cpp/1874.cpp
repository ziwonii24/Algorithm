#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>
#include <stack>
using namespace std;

int n;
int d[100001];
stack<int> s;
stack<char> ans;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> d[i];
		s.push(d[i]);
	}

	for (int i = 0; i < n; i++) {
		d[i] = s.top();
		s.pop();
	}

	int target = n;
	for (int i = 0; i < n; i++) {
		s.push(d[i]);
		ans.push('-');
		while(!s.empty()) {
			if (s.top() == target) {
				s.pop();
				ans.push('+');
				target--;
			}
			else
				break;
		}
	}

	if (!s.empty()) {
		cout << "NO\n";
		return 0;
	}

	int ans_size = ans.size();
	for (int i = 0; i < ans_size; i++) {
		cout << ans.top() << '\n';
		ans.pop();
	}

	return 0;
}
