from __future__ import unicode_literals
from django.db import models


# Create your models here.




class Shift(models.Model):
    month= models.CharField(max_length=50)
    from_day= models.IntegerField( default=0)
    to_day= models.IntegerField(default=0)
    user= models.CharField(max_length=50)
    added_by= models.CharField( max_length=50,default="Taha")
    eddited_by= models.CharField( max_length=50,default="None")
    def __str__ (self):
       return "{} - {} ".format(self.user ,self.month)
     





