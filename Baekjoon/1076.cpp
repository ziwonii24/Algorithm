#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <algorithm>
#include <map>
#include <string>
using namespace std;

int main() {
	map<string, pair<int, int>> m;
	m["black"] = { 0,1 };
	m["brown"] = { 1,10 };
	m["red"] = { 2,100 };
	m["orange"] = { 3,1000 };
	m["yellow"] = { 4,10000 };
	m["green"] = { 5,100000 };
	m["blue"] = { 6,1000000 };
	m["violet"] = { 7,10000000 };
	m["grey"] = { 8,100000000 };
	m["white"] = { 9,1000000000 };

	long long ans = 0;
	char c1[10], c2[10], c3[10];

	scanf("%s", &c1);
	scanf("%s", &c2);
	scanf("%s", &c3);

	ans = (m.find(c1)->second.first) * 10;
	ans += m.find(c2)->second.first;
	ans *= m.find(c3)->second.second;
	printf("%lld", ans);

	return 0;
}
