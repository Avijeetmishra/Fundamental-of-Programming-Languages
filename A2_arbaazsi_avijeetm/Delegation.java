
	public class Delegation {
		public static void main(String args[]) {
			C c = new C();
			System.out.println(c.r());
			D d = new D();
			System.out.println(d.r());
			
			C2 c2 = new C2();
			System.out.println(c2.r());
			D2 d2 = new D2();
			System.out.println(d2.r());	
		}
	}
	
	interface IA{
		public int f();
        int p(int m);
        int q(int m);
        int geta1();
        int geta2();
		
	}
	
	interface IB extends IA{
		public int g();
		public int p(int m);
		public int q(int m);
		int getb1();
        int getb2();
	}
	interface IC extends IB{
		public int r();
		public int p(int m);
		public int q(int m);
		int getc1();
        int getc2();
	}
	interface ID extends IB{
		public int p(int m);
		public int r();
		int getd1();
        int getd2();
		
	}
	  class A2 implements IA {
		  public A2(IA p) {
				this2 = p;
			}
		  	public int a1 = 1;
		  	public int a2 = 2;
			public int f() {
				return a1 + p(100) + q(100);
			}
			public int p(int m) {
				return this2.p(m);
			}
			public int q(int m) {
				return this2.q(m);
			}
			public int geta1() {
				return a1;
			}
			public int geta2() {
				return a2;
			}
			IA this2;
	 }
	  class B2 implements IB {
		  	public int b1 = 10;
		  	public int b2 = 20;
			public B2(IB p) {
				this3 = p;
				super2 = new A2(p);
			}
			public int g() {
				return f() + this.q(200);
			}

			public int p(int m) {
				return m + b1;
			}

			public int q(int m) {
				return m + b2;
			}
			public int f() {
				return super2.f();
			}
			public int geta1() {
				return super2.geta1();
			}
			public int geta2() {
				return super2.geta2();
			}
			public int getb1() {
				return b1;
			}
			public int getb2() {
				return b2;
			}
			IA this3;
			IA super2;
	 }
	  class C2 implements IC {
			int c1 = 100;
			int c2 = 200;
			public C2() {
				super1 = new B2(this);
			}
			public int r() {
				return f() + g() + c1;
				}
			
			public int p(int m) {
				return super1.p(m) + super1.q(m) + c2;
			}
			
			public int q(int m) {
				int a2 = super1.geta2();
				int b2 = super1.getb2();
				return m + a2 + b2 + c2;
			}
			public int f() {
				return super1.f();
			}
			public int g() {
				
				return f() + this.q(200);
			}
			public int geta1() {
				return super1.geta1();
			}
			public int geta2() {
				return super1.geta2();
			}
			public int getb1() {
				return super1.getb1();
			}
			public int getb2() {
				return super1.getb2();
			}
			public int getc1() {
				return c1;
			}
			public int getc2() {
				return c2;
			}
			IB super1;
	 }
	  class D2 implements ID {
		  	int d1 = 300;
			int d2 = 400;
			public D2() {
				super3 = new B2(this);
			}
			public int p(int m) {
				int a1 = super3.geta1();
				int b1 = super3.getb1();
				return m + a1 + b1 + d1;
				
			}
			public int r() {
				return f() + g() + d2;
			}
			public int g() {
				
				return f() + this.q(200);
			}
			public int f() {
				return super3.f();
			}
			public int q(int m) {
				return super3.q(m);
			}
			public int geta1() {
				return super3.geta1();
			}
			public int geta2() {
				return super3.geta2();
			}
			public int getb1() {
				return super3.getb1();
			}
			public int getb2() {
				return super3.getb2();
			}
			public int getd1() {
				return d1;
			}
			public int getd2() {
				return d2;
			}
			IB super3;

	 }
	
	
	 abstract class A {
		int a1 = 1;
		int a2 = 2;

		public int f() {
			return a1 + p(100) + q(100);
		}

        protected abstract int p(int m);
        protected abstract int q(int m);
	 }
	
	 
	 class B extends A {
		int b1 = 10;
		int b2 = 20;

		public int g() {
			return f() + this.q(200);
		}

		public int p(int m) {
			return m + b1;
		}

		public int q(int m) {
			return m + b2;
		}
	}
	 

	class C extends B {
		int c1 = 100;
		int c2 = 200;

		public int r() {
			return f() + g() + c1;
			}
		
		public int p(int m) {
			return super.p(m) + super.q(m) + c2;
		}
		
		public int q(int m) {
			return m + a2 + b2 + c2;
		}
	}

	class D extends B {
		int d1 = 300;
		int d2 = 400;
		
		public int p(int m) {
			return m + a1 + b1 + d1;
			
		}
		public int r() {
			return f() + g() + d2;
		}

	}
