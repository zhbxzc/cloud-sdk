package com.love.life.sdk;

public class Page {
		
		/**
		 * 当前页号, 采用自然数计数 1,2,3,...
		 */
		private int num;
		
		/**
		 * 页面大小
		 */
		private int size;
		
		/**
		 * 数据总数
		 */
		private int rowCount;
		
		/**
		 * 页面总数
		 */
		private int count;
		
		/**
		 * 当前页面开始行, 第一行是0行
		 */
		private int startRow;
		
		/**
		 * 第一页 页号
		 */
		private int first = 1;
		
		/**
		 * 最后页 页号
		 */
		private int last;
		
		/**
		 * 下一页 页号
		 */
		private int next;
		
		/**
		 * 前页 页号
		 */
		private int prev;
		
		/**
		 * 页号式导航, 起始页号
		 */
		private int start;
		
		/**
		 * 页号式导航, 结束页号
		 */
		private int end;
		
		/**
		 * 页号式导航, 显示页号数量
		 */
		private int numCount = 5;

		/**
		 * 
		 * @param size 每一页共显示多少条
		 * @param num 页码
		 * @param rowCount 数据库中一个有多少条数据
		 */
		public Page(int size, int num, int rowCount) {
			this.num = num;
			this.size=size;
			this.rowCount = rowCount;
			this.count = (int) Math.ceil((double)rowCount/size);
			
			this.num = Math.min(this.num, count);
			this.num = Math.max(1, this.num);
			
			this.startRow = (this.num-1) * size ;
			this.last = this.count;
			this.next = Math.min( this.count, this.num+1);
			this.prev = Math.max(1 , this.num-1);
		
			//计算page 控制
			start = Math.max(this.num-numCount/2, first);
			end = Math.min(start+numCount, last);
			if(end-start < numCount){
				start = Math.max(end-numCount, 1);
			}
			
		}

		public int getCount() {
			return count;
		}

		public void setCount(int count) {
			this.count = count;
		}

		public int getFirst() {
			return first;
		}

		public void setFirst(int first) {
			this.first = first;
		}

		public int getLast() {
			return last;
		}

		public void setLast(int last) {
			this.last = last;
		}

		public int getNext() {
			return next;
		}

		public void setNext(int next) {
			this.next = next;
		}

		public int getNum() {
			return num;
		}

		public void setNum(int num) {
			this.num = num;
		}

		public int getPrev() {
			return prev;
		}

		public void setPrev(int prev) {
			this.prev = prev;
		}

		public int getRowCount() {
			return rowCount;
		}

		public void setRowCount(int rowCount) {
			this.rowCount = rowCount;
		}

		public int getSize() {
			return size;
		}

		public void setSize(int size) {
			this.size = size;
		}

		public int getStartRow() {
			return startRow;
		}

		public void setStartRow(int startRow) {
			this.startRow = startRow;
		}

		public int getEnd() {
			return end;
		}

		public void setEnd(int end) {
			this.end = end;
		}

		public int getNumCount() {
			return numCount;
		}

		public int getStart() {
			return start;
		}

		public void setStart(int start) {
			this.start = start;
		}
}

