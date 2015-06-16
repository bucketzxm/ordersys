__author__ = 'simon'
from django.core import serializers

try:
    import cPickle as pickle
except:
    import pickle


# deserialize django models object
def deserialize_to_object_list(data, format):
    ret = []
    for obj in serializers.deserialize(format, data):
        ret.append(obj)
    return ret


# serialize django models object
def serialize(object_list, new_object, format):
    object_list.append(new_object)
    data = serializers.serialize(format, object_list)
    return data


def pickle_dump(new_object):
    return pickle.dumps(new_object)


def pickle_load(data):
    data_str = ""
    if isinstance(data, unicode):
        data_str = data.encode('utf-8')
    elif isinstance(data, str):
        data_str = data
    ret = pickle.loads(data_str)
    return ret
