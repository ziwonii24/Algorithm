#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <cstdlib>
#include <algorithm>
#include <vector>
#include <functional>
#include <cstring>
#include <string>
using namespace std;

int uNum, sNum;
vector<int> v[1000];
pair<int, int> p[1000];
vector<int> set[1000];

int u[1000];
int result;

void sorting() {
	for (int i = 0; i < sNum; i++) {
		p[i].first = v[i].size();
		p[i].second = i;
	}

	sort(p, p + sNum, greater<pair<int, int>>());

	for (int i = 0; i < sNum; i++) {
		for (auto it : v[p[i].second])
			set[i].push_back(it);
	}
}

bool pruning(int idx, int cnt) {
	bool tf = true;
	int cnt_s = 0, cnt_u = 0;
	bool vis[1000];
	memset(vis, false, sizeof vis);

	for (int i = idx; i < sNum; i++) {
		for (auto it : set[i]) {
			if (!u[it - 1] && !vis[it - 1]) {
				cnt_s++;
				vis[it - 1] = true;
			}
		}
	}

	for (int i = 0; i < uNum; i++) {
		if (!u[i])
			cnt_u++;
	}

	if (!cnt_u) {
		result = min(result, cnt);
		tf = false;
		return tf;
	}

	if (cnt_s < cnt_u) {
		tf = false;
		return tf;
	}

	for (int i = 0; i < uNum; i++) {
		if (!u[i] && !vis[i]) {
			tf = false;
			break;
		}
	}

	return tf;
}

void setcover(int idx, int cnt) {
	if (idx >= sNum) return;
	if (!pruning(idx, cnt)) return;

	for (auto it : set[idx])
		u[it - 1]++;

	setcover(idx + 1, cnt + 1);

	for (auto it : set[idx])
		u[it - 1]--;

	setcover(idx + 1, cnt);
}

int main(void) {
	std::ios::sync_with_stdio(false);
	cin >> uNum;
	cin >> sNum;
	cin.ignore();

	for (int i = 0, x, y; i < sNum; i++) {
		string s;
		getline(cin, s);
		for (int j = 0; j < s.size(); j++) {
			x = y = 0;
			while (s[j] != ' ') {
				x = s[j] - '0';
				if (y) {
					y *= 10;
					y += x;
				}
				else {
					y += x;
				}

				if (j + 1 < s.size())
					j++;
				else if (j + 1 == s.size())
					break;
			}
			v[i].push_back(y);
		}
	}

	sorting();

	for (int i = 0; i < uNum; i++)
		u[i] = 0;

	result = sNum;
	setcover(0, 0);

	cout << result << '\n';
}