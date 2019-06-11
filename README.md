# Quotes

This application currently returns a random quote from a JSON file.  This application has a static method than can be used for reading an Array of Quote objects from a JSON file.  Once read in a random index is generated and then printed to the user.

## Structure

```App.class```
```-public static Quote getQuoteFromAPI()```This method returns a quote and if the API fails returns a quote from cache via calling getQuoteFromFile()
```-public static boolean addQuoteToFile(Quote quote)```This method takes in a quote and appends it to the quotes file.
```-public static Quote getQuoteFromFile()```This method returns a quote from the file.
```-public static boolean writeToJson(Quote[] quotes)``` Takes in a array of Quote objects and returns a boolean.
```-public static Quote[] readFromJson(String fileName)```Takes in a filename (String) and returns an array of Quotes.
```Quote.class```
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
