from django.urls import path
from . import views

urlpatterns = [
path('submit/shift',views.submit_shift,name='submit_shift'),
path('query/by_name',views.query_by_name,name='query_by_name'),
path('query/by_date',views.query_by_date,name='query_by_date'),
path('query/by_month',views.query_by_month,name='query_by_month'),
path('update',views.update,name='update'),
]