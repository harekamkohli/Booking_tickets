// Harekam Singh Kohli     
// SBU ID- 115148763
// CSE-114
//kohli_harekam_hw4

import java.util.*;
	class Address{
		private String name;
		private String street;
		private String city;
		private String zipCode;
		
		public Address(String name, String street, String city, String zipcode) {
			this.name= name;
			this.street = street;
			this.city =city;
			setZipCode(zipCode);
		}
		
		public Address() {
			this.name= " ";
			this.street= " ";
			this.city= " ";
			this.zipCode= " ";			
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getStreet() {
			return street;
		}
		
		public void setStreet(String street) {
			this.street= street;
		}
		
		public String getCity() {
			return city;
		}
		
		public void setCity(String city) {
			this.city= city;
		}
		
		public String getZipCode() {
			return zipCode;
		}
		
		public void setZipCode(String zipCode) {
			if (zipCode.matches("[0-9]+") ) {
				this.zipCode = zipCode;
			}
			else {
					System.out.println("Invalid zip code");
				}
			}
			
			public void inputAddress() {
				Scanner input = new Scanner(System.in);
				System.out.println("Enter the name: ");
				this.name = input.nextLine();
				System.out.println("Enter the street: ");
				this.street = input.nextLine();
				System.out.println("Enter the city: ");
				this.city = input.nextLine();
				System.out.println("Enter the zip code: ");
				this.zipCode = input.nextLine();				
			}
			
			public void printAddress() {
				System.out.println("Name: " + this.name);
				System.out.println("Street: " + this.street);

				System.out.println("City: " + this.city);
				System.out.println("Zip Code: " + this.zipCode);
			}
			
			public boolean isEqualAddress(Address address) {
				return this.name.equals(address.name) && this.street.equals(address.street) && this.city.equals(address.city) && this.zipCode.equals(address.zipCode);
			}
		}
	
	class TicketOrder { 
		private String name;
		private Address address;
		private int numberOfTickets;
		
		public TicketOrder(String name, Address address, int numberOfTickets) {
			this.name = name;
			this.address =address;
			this.numberOfTickets =numberOfTickets;
		}
		
		public TicketOrder() {
			this.name = "";
			this.address = new Address();
			this.numberOfTickets = 0;
		}
		
		public String getName() {
			return name;
		}
		
		public void setName(String name) {
			this.name=name;
		}
		
		public Address getAddress() {
			return address;
		}
		
		public void setAddress(Address address) {
			this.address = address;
		}
		
		public int getNumberOfTickets() {
			return numberOfTickets;
		}
		
		public void setNumberOfTickets(int numberOfTickets) {
			this.numberOfTickets = numberOfTickets;
		}
		
		public void inputTicketOrder() {
			Scanner input= new Scanner(System.in);
			System.out.println("Enter the name: ");
			this.name = input.nextLine();
			System.out.println("Enter the street: ");
			this.address.setStreet(input.nextLine());
			System.out.println("Enter the city: ");
			this.address.setCity(input.nextLine());
			System.out.println("Enter the zip code: ");
			this.address.setZipCode(input.nextLine());
			System.out.println("Enter the number of tickets: ");
			this.numberOfTickets = input.nextInt();
		}
	
		{
		if(numberOfTickets > 4) {
			System.out.println("You can buy 4 tickets at a time!");
		}
	}
		
		public void printTicketOrder() {
			System.out.println("Name: " + this.name );
			System.out.println("Street: " + this.address.getStreet());
			System.out.println("City: " + this.address.getCity());
			System.out.println("Zip code: " + this.address.getZipCode());
			System.out.println("Number of Tickets: " + this.numberOfTickets);
			
		}
		
		public boolean isEqualTickets(TicketOrder ticketOrder) {
			return this.name.equals(ticketOrder.name) && this.address.isEqualAddress(ticketOrder.address);
		}
	}
	
	public class Tickets{
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			ArrayList<TicketOrder> ticketOrders = new ArrayList<TicketOrder>();
			
			Scanner input= new Scanner (System.in);
			System.out.println("Enter the value of Max: ");
			int MAX = Integer.parseInt(input.nextLine());
			int ticketsSold = 0;
			
			while(true) {
				TicketOrder ticketOrder = new TicketOrder();
				ticketOrder.inputTicketOrder();
				ticketOrders.add(ticketOrder);
				ticketsSold += ticketOrder.getNumberOfTickets();
				
				if(ticketsSold > MAX) {
					checkNumberOfTickets(ticketOrders);
					checkMultipleOrders(ticketOrders);
					
					if (ticketsSold> MAX) {
						System.out.println("The number of tickets sold already reached MAX and no more tickets are left.");
						break;
					}			
				}
				int ticketsLeft= MAX-ticketsSold;
				if(ticketsSold > MAX) {
					System.out.println("The tickets left are: "+ ticketsLeft);
				
			}
				
			} 
			
			for (TicketOrder ticketOrder: ticketOrders) {
				ticketOrder.printTicketOrder();			
			}
			input.close();
			
		}
		
		public static void checkNumberOfTickets(ArrayList<TicketOrder> ticketOrders) {
			for (int i=0; i< ticketOrders.size(); i++) {
				if(ticketOrders.get(i).getNumberOfTickets()>4) {
					ticketOrders.remove(i);
				}
			}
		}
		
		public static void checkMultipleOrders(ArrayList<TicketOrder> ticketOrders) {
			for(int i=0; i<ticketOrders.size(); i++) {
				for (int j=i+1; j<ticketOrders.size(); j++) {
					if(ticketOrders.get(i).isEqualTickets(ticketOrders.get(j)))
						ticketOrders.remove(j);				
				}
			}
		}
		

	}