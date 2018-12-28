#define _CRT_SECURE_NO_WARNINGS
#include <iostream>
#include <cstdio>
#include <algorithm>
#include <cstring>
#include <string>
using namespace std;

int a, b, c, m;
string s;
int d[10];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> a >> b >> c;
	m = a * b* c;
	s = to_string(m);

	for (int i = 0; i < 10; i++)
		d[i] = 0;

	for (int i = 0; i < s.size(); i++)
		d[s[i]-'0'] += 1;

	for (int i = 0; i < 10; i++)
		cout << d[i] << '\n';

	return 0;
}
