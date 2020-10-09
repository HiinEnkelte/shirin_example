Topic words identification from Corpus (datasets) using Probase (probabilistic knowledge provided by Probase[1])

Topic model is a type of statistical model for discovering the abstract "topics" that occur in a collection of documents. Topic modeling is a frequently used text-mining tool for discovery of hidden semantic structures in a text body. Here topics has been chosen based on 20 different newsgroup dataset and Probase.  
Probase is Microsoft project based on probabilistic knowledge base which gives the results with the most frequent concept and their probability. Here is demo: https://concept.research.microsoft.com/Home/Demo?instance=microsoft&smooth=0.0001

We will load the Probase database into MySQL and find the concept list for each word in document and select the highest n concept with probabilities for each document. Then the topic concept will be chosen from this information using LDA topic model. LDA topic model is a traditional topic model which select topic information from corpus using statistic methods. 

The procedures are mentioned below.
Step 1: Preprocess the corpus
a)	Download the datasets 20 different newsgroups, each corresponding to a different topic from the http://qwone.com/~jason/20Newsgroups/
b)	Tokenization and Remove stop words using mallet (A java package for converting text to tokenization and removing unnecessary word) [2] and Convert and get a vocabulary list with index (My Original code)
          Execution:     
          Go to Dir: mallet-2.0.8
  Run the command below:
bin/mallet import-dir --input ./topic_model/data/input/ --output ./topic_model/data/input.mallet --keep-sequence --remove-stopwords  

c)	Remove most common word and email.  (Use python code to remove more unnecessary words from list such as this, us, email address etc.) (Original code)
Run the preprocess.py code on an environment with the dataset
d)	Convert all document to index using vocabulary. (Original code)
 Run the command below
java -cp .:lib/* ./PbaseLDA/test/GetVocab

Step 2: Conceptualization (Retrieve concepts and highest probability of concept corresponding to word using Poobase )
a)	Load the Probase database into MySQL (can be downloaded from here http://pan.baidu.com/s/1qXvIgXI)
b)	Find the concept list for each word in documents in Corpus [1]
c)	Select the highest n (10) concept probabilities for each document [1] 
Step 2 has been done using the command
java -cp .:lib/* ./PbaseLDA/test/RunConceptualizations

Step 3: Find the topic concept using LDA model which can be found by the executing the following command. LDA model usually select the topic information from corpus (for specific groups such as medical, political, etc).
java -cp .:lib/* ./PbaseLDA/test/MultiDomainTask 
15 topics are chosen in this project for each group in corpus. 

References:
[1] Yao L., Zhang Y., Wei B., Qian H., Wang Y. (2015) Incorporating Probabilistic Knowledge into Topic Models. In: Cao T., Lim EP., Zhou ZH., Ho TB., Cheung D., Motoda H. (eds) Advances in Knowledge Discovery and Data Mining. PAKDD 2015. Lecture Notes in Computer Science, vol 9078. Springer, Cham. https://doi.org/10.1007/978-3-319-18032-8_46 
[2] http://mallet.cs.umass.edu/topics.php
