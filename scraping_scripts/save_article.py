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

authors_dict = {}
dates_dict = {}
cities_dict = {}

for article in scrapr.get_articles():
    # existing_duplicates = db['articles'].find({'articleid' : article['articleid']}).count()
    # if existing_duplicates == 0:
    # article['_id'] = ObjectId()
    author_city = scrapr.get_author(article['url'])
    article['tags'] = author_city['tags']
    try:
        article['author'] = author_city['author']
    except:
        article['author'] = ""
    article['city'] = author_city['city']
    if article['date'][:4] in article['city']:
        article['city'] = ""
    # db['articles'].insert(article)
    with open("articles.csv", 'a') as f:
        w = csv.DictWriter(f, article.keys())
        # w.writeheader()
        w.writerow(article)

    if article['author'] not in authors_dict.keys():
        authors_dict[article['author']] = [article['articleid']]
    else:
        authors_dict[article['author']].append(article['articleid'])

    if article['date'] not in dates_dict.keys():
        dates_dict[article['date']] = [article['articleid']]
    else:
        dates_dict[article['date']].append(article['articleid'])

    if article['city'] not in cities_dict.keys():
        cities_dict[article['city']] = [article['articleid']]
    else:
        cities_dict[article['city']].append(article['articleid'])


for k,v in authors_dict.iteritems():
    t = {"author": k, "articleids": v}
    with open("authors.csv", 'a') as f:
        w = csv.DictWriter(f, t.keys())
        # w.writeheader()
        w.writerow(t)

for k,v in dates_dict.iteritems():
    t = {"date": k, "articleids": v}
    with open("dates.csv", 'a') as f:
        w = csv.DictWriter(f, t.keys())
        # w.writeheader()
        w.writerow(t)

for k,v in cities_dict.iteritems():
    t = {"city": k, "articleids": v}
    with open("cities.csv", 'a') as f:
        w = csv.DictWriter(f, t.keys())
        # w.writeheader()
        w.writerow(t)

    # print(article)
    # print("Inserted article", article["articleid"], "from date", article['date'])
    # else:
    #     print("Record already found..", article['article_id'])
