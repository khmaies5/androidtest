**XPATH**

1- //book
2- //book[@type='roman']/title
3- count(//book[@type='bd'])
4- cette expression "/library/library/ancestor-or-self::library" renvoie tous les libraries dans le XML :
```
<library>...</library>
 <library>...</library>
  <library>...</library>
```
