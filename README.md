# NewsChannel API

This project provides RESTful APIs to interact with news articles based on specified criteria. It utilizes the News API to fetch news articles and perform various operations such as keyword analysis and topic frequency calculation.

## Setup Instructions

### Prerequisites

Before running the application, ensure you have:

- Java Development Kit (JDK) installed
- Gradle build tool installed

### Configuration

1. Clone the repository:
   ```bash
   git clone https://github.com/your-username/NewsChannel.git
   cd NewsChannel
2. Navigate to the project directory:
   cd path/to/NewsChannel
3. Configure API key:
   Obtain an API key from https://newsapi.org/ .
   Add the API key to your environment variables or update application.properties:

   news.api.key=your_api_key_here
   
   news.api.url=https://newsapi.org/v2/everything

Running the Application :

To build and run the application locally:
./gradlew build
./gradlew bootRun

API Endpoints
1. Fetch Common Topics
    Endpoint: /api/news/common-topics
   
    Method: GET
   
    Parameters:
    startDate (Date, required): Start date in format yyyy-MM-dd.
    endDate (Date, required): End date in format yyyy-MM-dd.

    Description: Retrieves common topics based on news articles published between startDate and endDate.


3. Count Keyword Occurrences
  Endpoint: /api/news/keyword-count

  Method: GET
  
  Parameters:
  keyword (String, required): Keyword to search within news articles.
  startDate (Date, required): Start date in format yyyy-MM-dd.
  endDate (Date, required): End date in format yyyy-MM-dd.
  
  Description: Counts occurrences of a specific keyword in news articles published between startDate and endDate.


5. Fetch Common Keywords
   
    Endpoint: /api/news/common-keywords
    
    Method: GET
    
    Parameters:
    threshold (Integer, required): Minimum frequency threshold for keywords.
    startDate (Date, required): Start date in format yyyy-MM-dd.
    endDate (Date, required): End date in format yyyy-MM-dd.
    
    Description: Retrieves common keywords with frequency equal to or greater than threshold in news articles published between startDate and endDate.


7. Fetch Uncommon Keywords
Endpoint: /api/news/uncommon-keywords

Method: GET

Parameters:
threshold (Integer, required): Maximum frequency threshold for keywords.
startDate (Date, required): Start date in format yyyy-MM-dd.
endDate (Date, required): End date in format yyyy-MM-dd.

Description: Retrieves uncommon keywords with frequency less than threshold in news articles published between startDate and endDate.



- Example API Calls
Assuming the application is running locally:

Fetch Common Topics:
curl -X GET 'http://localhost:8080/api/news/common-topics?startDate=2024-05-22&endDate=2024-05-24'


Count Keyword Occurrences:
curl -X GET 'http://localhost:8080/api/news/keyword-count?keyword=technology&startDate=2024-05-22&endDate=2024-05-24'


Fetch Common Keywords:
curl -X GET 'http://localhost:8080/api/news/common-keywords?threshold=5&startDate=2024-05-22&endDate=2024-05-24'


Fetch Uncommon Keywords:
curl -X GET 'http://localhost:8080/api/news/uncommon-keywords?threshold=2&startDate=2024-05-22&endDate=2024-05-24'

Notes
Replace your_api_key_here in application.properties with your actual News API key.
Adjust port number (8080) in API calls if your application runs on a different port.

