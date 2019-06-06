# Quotes

This application currently returns a random quote from a JSON file.  This application has a static method than can be used for reading an Array of Quote objects from a JSON file.  Once read in a random index is generated and then printed to the user.

## Struture
```App```   
```-public static Quote[] readFromJson(String fileName)``` Takes in a filename (String) and returns an array of Quotes.  
```Quote Class```    
  ```-public String toString() ```Returns a string containing the author and text of the quote.  

## Dependencies
```
dependencies {
 compile 'com.google.code.gson:gson:2.8.2'
}
```
## Clone

Follow normal git procedures usually something similar to;
```git clone <repo url>```

## Run
To run the program run.  
```./gradlew run```  
To test the program run.  
```./gradlew test```  
