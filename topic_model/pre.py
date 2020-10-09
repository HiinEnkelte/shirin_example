# -*- coding: utf-8 -*-
"""
Created on Wed Apr 29 00:14:45 2020

@author: Shirin
"""
import re
import pandas as pd
import gensim
from gensim.utils import simple_preprocess
from gensim.parsing.preprocessing import STOPWORDS
from nltk.stem import WordNetLemmatizer, SnowballStemmer
from nltk.stem.porter import *
from nltk.tokenize import RegexpTokenizer
from nltk.stem import WordNetLemmatizer,PorterStemmer
import numpy as np
np.random.seed(400)
import nltk


import re
lemmatizer = WordNetLemmatizer()
stemmer = PorterStemmer() 

def preprocess(sentence):
    sentence=str(sentence)
    sentence = sentence.lower()
    sentence=sentence.replace('{html}',"") 
    cleanr = re.compile('<.*?>')
    cleantext = re.sub(cleanr, '', sentence)
    rem_url=re.sub(r'http\S+', '',cleantext)
    rem_num = re.sub('[0-9]+', '', rem_url)
    tokenizer = RegexpTokenizer(r'\w+')
    tokens = tokenizer.tokenize(rem_num)  
    return tokens

emails = ', '.join(re.findall("\<(.*?)\>", addresses))
def listToString(s):  
    
    # initialize an empty string 
    str1 = " " 
    #print(str1.join(s))
    # return string   
    return (str1.join(s))
            

# Tokenize and lemmatize
def preprocess(text):
    result=[]
    for token in text :
        token=preprocess(token)
        if token not in gensim.parsing.preprocessing.STOPWORDS and len(token) > 3:
            result.append(token)
            
    return result

processed_docs = []
#for doc in newsgroups_train.data:
 #   processed_docs.append(preprocess(doc))
    
import en_core_web_sm
nlp = en_core_web_sm.load()
lemma_word1 = []   
    
with open('D:/voc.txt', 'r') as myfile:
     data = myfile.read()
     processed_docs.append(preprocess(data))
    
with open('D:/project/data/voc.txt', 'r') as myfile:
     data = myfile.read()   
     for tokens in nlp(data) :    
       s=tokens.lemma_
       #print(s)
       if s not in gensim.parsing.preprocessing.STOPWORDS and len(s) > 3:
          processed_docs.append(s)
          print(s)
     #processed_docs.append(preprocess(data))     


print(processed_docs[:2])


np.savetxt("D:/vocc.txt", np.array(processed_docs[:2]),delimiter='\n', fmt="%s")