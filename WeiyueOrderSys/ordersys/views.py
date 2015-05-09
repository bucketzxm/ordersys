from django.shortcuts import render_to_response


def index(request):
    return render_to_response('index.html', None)


def category(request):
    return render_to_response("category.html", None)


def mydish(request):
    return render_to_response("mydish.html", None)