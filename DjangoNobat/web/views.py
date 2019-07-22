from django.shortcuts import render
from django.http import JsonResponse
from json import JSONEncoder
import json
from django.views.decorators.csrf import csrf_exempt
from web.models import *
from django.shortcuts import render, get_object_or_404
from django.core import serializers
from django.core.serializers.json import DjangoJSONEncoder


### Create your views here.

@csrf_exempt
def submit_shift(request):
    user_name=request.GET['user']
    month_name=request.GET['month']
    this_from_day= request.GET['from']
    this_to_day= request.GET['to']

    Shift.objects.create(user=user_name,month=month_name,from_day=this_from_day,to_day=this_to_day)


    return JsonResponse({
        "status" : "ok"
    }, encoder=JSONEncoder)


@csrf_exempt
def query_by_name(request):
    user_name=request.GET['user']
    
    shift= Shift.objects.filter(user=user_name).all()
    context={}
    shift_serialized= serializers.serialize("json",shift)
    
    context["shift"]= json.loads(shift_serialized)
  
    
    return JsonResponse(context, encoder=JSONEncoder,safe=False)


@csrf_exempt
def query_by_month(request):
    this_month=request.GET['month']
    #request.POST.get('is_private', False)
    shift= Shift.objects.filter(month=this_month).all()
    context={}
    shift_serialized= serializers.serialize("json",shift)
    
    context["shift"]= json.loads(shift_serialized)
    
    return JsonResponse(context, encoder=JSONEncoder,safe=False)
    
    
    