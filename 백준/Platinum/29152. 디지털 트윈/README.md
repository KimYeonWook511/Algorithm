# [Platinum V] 디지털 트윈 - 29152 

[문제 링크](https://www.acmicpc.net/problem/29152) 

### 성능 요약

메모리: 573008 KB, 시간: 1500 ms

### 분류

다이나믹 프로그래밍

### 제출 일자

2025년 7월 8일 18:40:47

### 문제 설명

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/3051e512-937e-4f4d-b0e1-dc6f7d4308ef/-/preview/" style="width: 50%;"></p>

<p><b>디지털 트윈</b>은 현실 속 환경을 디지털 가상 공간에 복제하여 물리 환경에서 발생 가능한 상황을 예측하고 최적화하는 기술이다.</p>

<p>미래 제조업의 핵심 경쟁력인 스마트 팩토리 SW 기술을 개발하는 현대오토에버는, 디지털 트윈 기술을 자체 개발한 스마트 팩토리 솔루션에 접목하여 고객의 스마트 팩토리가 최적의 상태로 운영되도록 지원하고 있다.</p>

<p>현대오토에버의 스마트 팩토리 설계자인 당신은 기존에 설계된 공장 컨테이너 벨트 위치를 더욱 효율적이고 생산적으로 바꾸려고 한다. 개선 작업을 시작하기 앞서, 당신은 디지털 트윈 기술을 활용하여 실제 공장 내에서의 작업을 가상 공간에서 시뮬레이션해 보고자 한다.</p>

<p>가상 공간에서의 공장은 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>×</mo><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N \times N$</span></mjx-container> 크기의 격자로 나타낼 수 있고, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>×</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \times 1$</span></mjx-container> 크기의 격자 위에 컨테이너 벨트를 하나 설치할 수 있다. 공장의 시작 점 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="2"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mn>1</mn><mo>,</mo><mn>1</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(1, 1)$</span></mjx-container>은 왼쪽 위이고 공장의 끝 지점 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mi>N</mi><mo>,</mo><mi>N</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(N, N)$</span></mjx-container>은 오른쪽 아래이며, 컨테이너 벨트는 공장의 시작 점에서 시작하여 끝 점을 통해 격자 밖으로 나오는 하나의 경로를 이뤄야 한다. 또한, 이동하는 도중에 격자를 벗어나서는 안 된다. 효율적으로 컨테이너 벨트를 설치하기 위한 디지털 트윈 기술의 피드백으로, 컨테이너 벨트는 세 가지 방향 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2190"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">←</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\leftarrow$</span></mjx-container>, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2192"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">→</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\rightarrow$</span></mjx-container>, <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2193"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">↓</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\downarrow$</span></mjx-container> 중 하나로만 설치할 수 있다. 구체적으로 현재 컨테이너 벨트의 위치가 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mi>r</mi><mo>,</mo><mi>c</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(r, c)$</span></mjx-container>일 때, 현재 벨트의 방향에 따라 이동하는 위치는 다음과 같다.</p>

<table border="1" cellpadding="1" cellspacing="1" class="table table-bordered" style="width: 500px; margin: 0 auto;">
	<tbody>
		<tr>
			<td style="text-align: center;"><strong>방향</strong></td>
			<td style="text-align: center;"><strong>다음 위치</strong></td>
		</tr>
		<tr>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2190"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">←</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\leftarrow$</span> </mjx-container></td>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2212"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mi>r</mi><mo>,</mo><mi>c</mi><mo>−</mo><mn>1</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(r, c - 1)$</span> </mjx-container></td>
		</tr>
		<tr>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2192"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">→</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\rightarrow$</span> </mjx-container></td>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mi>r</mi><mo>,</mo><mi>c</mi><mo>+</mo><mn>1</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(r, c + 1)$</span> </mjx-container></td>
		</tr>
		<tr>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2193"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">↓</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\downarrow$</span> </mjx-container></td>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D45F TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c2C"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="2"><mjx-c class="mjx-c1D450 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mi>r</mi><mo>+</mo><mn>1</mn><mo>,</mo><mi>c</mi><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$(r + 1, c)$</span> </mjx-container></td>
		</tr>
	</tbody>
</table>

<p>따라서, 끝 점에서는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2192"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">→</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\rightarrow$</span></mjx-container> 또는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c2193"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">↓</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\downarrow$</span></mjx-container>를 사용해야 격자 밖으로 나오는 올바른 경로를 구성할 수 있음에 유의하자.</p>

<p>생산 기계들의 위치가 가상 공간에서의 위치로 주어질 때, 컨테이너 벨트는 안정적인 생산을 위해 모든 생산 기계를 꼭 지나가야 한다. 가상 공간이 주어졌을 때, 효율성의 극대화를 위해서 시작 점에서 출발하고 끝 점을 통과하여 격자 밖으로 나오도록 하는 컨테이너 벨트의 최소 개수를 구하라.</p>

<p>예시로 다음 그림을 살펴보자. 3, 4번 그림은 정답이 아닌 컨테이너 벨트의 상태를 나타낸다.</p>

<p style="text-align: center;"><img alt="" src="https://upload.acmicpc.net/103662aa-bfcc-43c4-bbd4-09bea24135b2/-/preview/" style="width: 80%;"></p>

<ul>
	<li>첫 번째 그림은 공장의 상태와 생산 기계들의 상태를 보여준다.</li>
	<li>두 번째 그림은 모든 기계를 지나가며 컨테이너 벨트를 설치하는 최소 경로이다.</li>
	<li>세 번째 그림은 모든 기계를 지나가지만 최소 경로가 아니다.</li>
	<li>네 번째 그림은 모든 생산 기계를 지나가지 않는다.</li>
</ul>

### 입력 

 <p>첫 줄에 공장의 크기 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>이 주어진다. <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mo class="mjx-n"><mjx-c class="mjx-c28"></mjx-c></mjx-mo><mjx-mn class="mjx-n"><mjx-c class="mjx-c32"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c35"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn><mjx-mo class="mjx-n"><mjx-c class="mjx-c29"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mo stretchy="false">(</mo><mn>2</mn><mo>≤</mo><mi>N</mi><mo>≤</mo><mn>5</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn><mo stretchy="false">)</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$( 2 \le N \le 5\, 000)$</span> </mjx-container></p>

<p>둘째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 줄에 걸쳐 ‘<span style="color:#e74c3c;"><code>0</code></span>’, ‘<span style="color:#e74c3c;"><code>1</code></span>’로 이루어진 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-cD7"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="3"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>×</mo><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N \times N$</span></mjx-container> 크기의 격자가 공백 없이 주어진다.</p>

<p>빈 부분의 위치는 ‘<span style="color:#e74c3c;"><code>0</code></span>’, 생산 기계의 위치는 ‘<span style="color:#e74c3c;"><code>1</code></span>’로 나타난다.</p>

### 출력 

 <p>공장의 시작에서 생산 기계를 모두 연결하면서 끝에 도달할 때 컨테이너 벨트의 최소 길이를 구하라.</p>

<p>만약, 모두 연결하는 것이 불가능하다면 “<span style="color:#e74c3c;"><code>-1</code></span>”을 출력해라.</p>

