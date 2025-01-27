#define _CRT_SECURE_NO_WARNINGS
#include <cstdio>
using namespace std;

int main(){
	int k, n, m;
	scanf("%d %d %d", &k, &n, &m);

	if (k*n - m < 0)
		printf("0\n");
	else
		printf("%d\n", k*n - m);

	return 0;
}
