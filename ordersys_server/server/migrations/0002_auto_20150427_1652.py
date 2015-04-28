# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
        ('server', '0001_initial'),
    ]

    operations = [
        migrations.CreateModel(
            name='Agent',
            fields=[
                ('agent_id', models.AutoField(serialize=False, primary_key=True)),
                ('agent_money', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('agent_moneycopy', models.DecimalField(null=True, decimal_places=2, max_digits=7, db_column='agent_moneyCopy', blank=True)),
            ],
            options={
                'db_table': 'agent',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AuthGroup',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('name', models.CharField(unique=True, max_length=80)),
            ],
            options={
                'db_table': 'auth_group',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AuthGroupPermissions',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
            ],
            options={
                'db_table': 'auth_group_permissions',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AuthPermission',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('name', models.CharField(max_length=255, null=True, blank=True)),
                ('codename', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'auth_permission',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AuthUser',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('password', models.CharField(max_length=128)),
                ('last_login', models.DateTimeField(null=True, blank=True)),
                ('is_superuser', models.IntegerField()),
                ('username', models.CharField(unique=True, max_length=30)),
                ('first_name', models.CharField(max_length=30)),
                ('last_name', models.CharField(max_length=30)),
                ('email', models.CharField(max_length=254, null=True, blank=True)),
                ('is_staff', models.IntegerField()),
                ('is_active', models.IntegerField()),
                ('date_joined', models.DateTimeField()),
            ],
            options={
                'db_table': 'auth_user',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AuthUserGroups',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
            ],
            options={
                'db_table': 'auth_user_groups',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='AuthUserUserPermissions',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
            ],
            options={
                'db_table': 'auth_user_user_permissions',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Category',
            fields=[
                ('category_id', models.AutoField(serialize=False, primary_key=True)),
                ('category_name', models.CharField(max_length=40, null=True, blank=True)),
                ('category_picture', models.CharField(max_length=45, null=True, blank=True)),
            ],
            options={
                'db_table': 'category',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Desk',
            fields=[
                ('desk_num', models.IntegerField(serialize=False, primary_key=True)),
            ],
            options={
                'db_table': 'desk',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DjangoAdminLog',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('action_time', models.DateTimeField()),
                ('object_id', models.TextField(null=True, blank=True)),
                ('object_repr', models.CharField(max_length=200)),
                ('action_flag', models.SmallIntegerField()),
                ('change_message', models.TextField()),
            ],
            options={
                'db_table': 'django_admin_log',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DjangoContentType',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('app_label', models.CharField(max_length=100)),
                ('model', models.CharField(max_length=100)),
            ],
            options={
                'db_table': 'django_content_type',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DjangoMigrations',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('app', models.CharField(max_length=255)),
                ('name', models.CharField(max_length=255)),
                ('applied', models.DateTimeField()),
            ],
            options={
                'db_table': 'django_migrations',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='DjangoSession',
            fields=[
                ('session_key', models.CharField(max_length=40, serialize=False, primary_key=True)),
                ('session_data', models.TextField()),
                ('expire_date', models.DateTimeField()),
            ],
            options={
                'db_table': 'django_session',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Evaluate',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('score', models.IntegerField(null=True, blank=True)),
            ],
            options={
                'db_table': 'evaluate',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Food',
            fields=[
                ('food_id', models.AutoField(serialize=False, primary_key=True)),
                ('food_score', models.DecimalField(null=True, max_digits=10, decimal_places=1, blank=True)),
                ('food_name', models.CharField(max_length=40, null=True, blank=True)),
                ('food_price', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('food_picture', models.CharField(max_length=40, null=True, blank=True)),
                ('food_description', models.CharField(max_length=400, null=True, blank=True)),
            ],
            options={
                'db_table': 'food',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Mac',
            fields=[
                ('mac_id', models.AutoField(serialize=False, primary_key=True)),
                ('mac_address', models.CharField(max_length=45, null=True, blank=True)),
                ('mac_time', models.CharField(max_length=45, null=True, blank=True)),
            ],
            options={
                'db_table': 'mac',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Menuitem',
            fields=[
                ('menuitem_id', models.AutoField(serialize=False, primary_key=True)),
                ('menuitem_bigsale', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('menuitem_status', models.IntegerField(null=True, blank=True)),
            ],
            options={
                'db_table': 'menuitem',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Orderitem',
            fields=[
                ('orderitem_id', models.AutoField(serialize=False, primary_key=True)),
                ('orderitem_status', models.IntegerField(null=True, blank=True)),
                ('orderitem_amount', models.IntegerField(null=True, blank=True)),
                ('orderitem_price', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('orderitem_owner', models.IntegerField(null=True, blank=True)),
            ],
            options={
                'db_table': 'orderitem',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Pay',
            fields=[
                ('pay_id', models.AutoField(serialize=False, primary_key=True)),
                ('pay_name', models.CharField(max_length=40, null=True, blank=True)),
                ('pay_merchant', models.CharField(max_length=40, null=True, blank=True)),
                ('pay_company', models.CharField(max_length=40, null=True, blank=True)),
            ],
            options={
                'db_table': 'pay',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Role',
            fields=[
                ('role_id', models.AutoField(serialize=False, primary_key=True)),
                ('role_name', models.CharField(max_length=40, null=True, blank=True)),
            ],
            options={
                'db_table': 'role',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='Special',
            fields=[
                ('special_id', models.AutoField(serialize=False, primary_key=True)),
                ('special_price', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('special_remain', models.IntegerField(null=True, blank=True)),
                ('special_quota', models.IntegerField(null=True, blank=True)),
                ('special_picture', models.CharField(max_length=45, null=True, blank=True)),
            ],
            options={
                'db_table': 'special',
                'managed': False,
            },
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('user_id', models.AutoField(serialize=False, primary_key=True)),
                ('user_name', models.CharField(max_length=40, null=True, blank=True)),
                ('user_account', models.CharField(max_length=40, null=True, blank=True)),
                ('user_passwd', models.CharField(max_length=40, null=True, blank=True)),
            ],
            options={
                'db_table': 'user',
                'managed': False,
            },
        ),
        migrations.AlterModelOptions(
            name='order',
            options={'managed': False},
        ),
    ]
