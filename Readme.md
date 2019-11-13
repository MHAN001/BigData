# Double 11 data analyzer

> <p>:octocat: This is final project of class INFO 7250</p>
## Project Goal
    Use complicate Hadoop Map Reduce job to analyze data based on different purpose
    Spring as the back end server to provide neccessary API
    Angular 8 as front end to provide user interface

## Environment
    Operation System: Ubuntu 18.04.3 LTS
    Java: JDK 1.8
    Hadoop version: Hadoop-3.2.1
    Hive version: Apache-Hive-3.1.2

## Data Description
    user_log.csv contains following fields：
        1. user_id: unqiue ids for different consumers
        2. item_id: unique ids for different items
        3. cat_id: unique category ids based on different items
        4. merchant_id: unique seller ids 
        5. brand_id: unique ids based on different brand of the item
        6. month: transaction month
        7. day: transaction date
        8. action: user action in range of [0, 3]. 0 represent click; 1 represent add to cart; 2 represent buy the item; 3 represent save item as favorite
        9. age_range: consumer(buyer) age range：
            0 and NULL represent unknown
            1 represent age < 18
            2 represent age between [18,24]
            3 represent age between [25,29]
            4 represent age between [30,34]
            5 represent age between [35,39]
            6 represent age between [40,49]
            7 and 8 represent age between >=50
        10. gender: consumer/buyer gender: 0 represent female, 1 represent male, 2 and NULL represent unknow
        11. province: consumer state address
    Data Link: [**Double 11.zip**](https://drive.google.com/open?id=1KV_uyniNjiKGzO7A370P9Nz1liqEC31S)<br>

## Architecture
    TODO

## Usage
    TODO
