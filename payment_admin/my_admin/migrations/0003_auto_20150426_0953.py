# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('my_admin', '0002_order_out_trade_num'),
    ]

    operations = [
        migrations.DeleteModel(
            name='DjangoSession',
        ),
        migrations.AlterModelOptions(
            name='agent',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='authgroup',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='authgrouppermissions',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='authpermission',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='authuser',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='authusergroups',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='authuseruserpermissions',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='category',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='desk',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='djangoadminlog',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='djangocontenttype',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='djangomigrations',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='evaluate',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='food',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='mac',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='menuitem',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='order',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='orderitem',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='pay',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='role',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='special',
            options={'managed': False},
        ),
        migrations.AlterModelOptions(
            name='user',
            options={'managed': False},
        ),
    ]
