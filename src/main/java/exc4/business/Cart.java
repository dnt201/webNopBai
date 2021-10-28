package exc4.business;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Cart implements Serializable
{
    
	private static final long serialVersionUID = 1L;
	
	//Cart will contain LineItems (Array LineItem)
	private ArrayList<LineItem> items;
    
	//Constructor
    public Cart()
    {
        items = new ArrayList<LineItem>();
    }
    
    public ArrayList<LineItem> getItems()
    { 
        return items;
    }
    
    //Amount of item
    public int getCount()
    { 
        return items.size();
    }
    
    public void addItem(LineItem item)
    {
        String code = item.getProduct().getCode();
        int quantity = item.getQuantity();
        for (int i = 0; i < items.size(); i++)
        {
        	//check xem đã có trong giỏ hàng chưa
            LineItem lineItem = items.get(i); 
            if (lineItem.getProduct().getCode().equals(code))
            {
                lineItem.setQuantity(lineItem.getQuantity()+quantity);
                return;
            }
        }
        items.add(item);
    }
    
    public void updateItem(LineItem item)
    {
    	String code = item.getProduct().getCode();
    	int quantity = item.getQuantity();
    	if(quantity <= 0) {
    		removeItem(item);
    	}
    	else {
    		for (int i = 0; i < items.size(); i++)
    		{
    			//Tìm thằng muốn update
    			LineItem lineItem = items.get(i); 
    			if (lineItem.getProduct().getCode().equals(code))
    			{
    				lineItem.setQuantity(quantity);
    				return;
    			}
    		}
    	}
    }
    
    
    public void removeItem(LineItem item)
    {
        String code = item.getProduct().getCode();
        for (int i = 0; i < items.size(); i++)
        {
            LineItem lineItem = items.get(i);
            if (lineItem.getProduct().getCode().equals(code))
            {
                items.remove(i);
                return;
            }
        }
    }
    
    public double getTotalMoneyDouble() {
    	double sum=0;
    	if(items.size()!=0) {
    		for(int i = 0; i < items.size(); i++){
    			sum+=items.get(i).getTotal();
    		}
    	}
    	return sum;
    }
    
    public String getTotalMoney() {
    	double sum=0;
    	if(items.size()!=0) {
    		for(int i = 0; i < items.size(); i++){
    			sum+=items.get(i).getTotal();
    		}
    	}
    	NumberFormat currency = NumberFormat.getCurrencyInstance();
        return currency.format(sum);
    }
    
    public void emptyCart() {
    	items.clear();
    }	
}