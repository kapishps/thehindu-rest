"""
Scraps the article and push it into the database
"""

import sys
from datetime import date

import argparse
import csv
from bson.objectid import ObjectId
from pymongo import MongoClient

from scraper import Scraper

client = MongoClient('mongodb://handzap1:handzap1@ds143604.mlab.com:43604/handzap')

db = client.scrap_test

arguments = argparse.ArgumentParser(
    description="Scraps the news document from the hindu archives"
)
arguments.add_argument(
    '--start-date',
    dest='start_date',
    default=date.today().strftime("%Y/%m/%d"),
    help="Start date of crawling"
)
arguments.add_argument(
    '--end-date',
    dest='end_date',
    default=date.today().strftime("%Y/%m/%d"),
    help="End date of crawling"
)
args = arguments.parse_args()

scrapr = Scraper(args.start_date, args.end_date)

for article in scrapr.get_articles():
    # existing_duplicates = db['articles'].find({'articleid' : article['articleid']}).count()
    # if existing_duplicates == 0:
    article['_id'] = ObjectId()
    author_city = scrapr.get_author(article['url'])
    try:
        article['author'] = author_city['author']
    except:
        pass
    article['city'] = author_city['city']
    # db['articles'].insert(article)
    with open(article['date'], 'wb') as f:  # Just use 'w' mode in 3.x
        w = csv.DictWriter(f, article.keys())
        w.writeheader()
        w.writerow(article)
    # print(article)
    # print("Inserted article", article["articleid"], "from date", article['date'])
    # else:
    #     print("Record already found..", article['article_id'])
