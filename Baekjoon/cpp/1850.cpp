#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
#include <cstring>
#include <string>
using namespace std;

long long gcd(long long a, long long b) {
	if (b == 0)
		return a;
	else
		return gcd(b, a%b);
}

int main() {
	long long a, b;
	scanf("%lld %lld", &a, &b);

	long long result;
	result = gcd(a, b);

	for (long long i = 0; i < result; i++)
		printf("1");
	printf("\n");

	return 0;
}
