package Model;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class ProductIterator implements Iterator {
	private List products;
	private int current;

	public ProductIterator(List productsCollection) {
		products = productsCollection;
		current = 0;
	}

	@Override
	public boolean hasNext() {
		if(current < this.products.size()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Object next() {
		if(!hasNext()) {
			throw new NoSuchElementException();
		}
		return products.get(current++);
	}
}
