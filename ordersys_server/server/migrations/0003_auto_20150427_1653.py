# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('server', '0002_auto_20150427_1652'),
    ]

    operations = [
        migrations.AlterModelTable(
            name='order',
            table='order',
        ),
    ]
