package exc4.business;


import java.io.Serializable;
import java.text.NumberFormat;

public class LineItem implements Serializable
{
	private static final long serialVersionUID = 1L;
	
	//Each LineItem will contain product and quantity of it.
	private Product product;
    private int quantity;
    
    public LineItem() {}
    
    public void setProduct(Product p)
    {
        product = p;
    }

    public Product getProduct()
    { 
        return product;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }
    
    public int getQuantity()
    { 
        return quantity; 
    }
    
    public double getTotal()
    { 
        double total = product.getPrice() * quantity;
        return total;
    }
    
    public String getTotalCurrencyFormat()
    {
        NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(this.getTotal());
    }
}