# -*- coding: utf-8 -*-
from __future__ import unicode_literals

from django.db import models, migrations


class Migration(migrations.Migration):

    dependencies = [
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
            },
        ),
        migrations.CreateModel(
            name='AuthGroupPermissions',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('group', models.ForeignKey(to='my_admin.AuthGroup')),
            ],
            options={
                'db_table': 'auth_group_permissions',
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
            },
        ),
        migrations.CreateModel(
            name='AuthUserGroups',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('group', models.ForeignKey(to='my_admin.AuthGroup')),
                ('user', models.ForeignKey(to='my_admin.AuthUser')),
            ],
            options={
                'db_table': 'auth_user_groups',
            },
        ),
        migrations.CreateModel(
            name='AuthUserUserPermissions',
            fields=[
                ('id', models.AutoField(verbose_name='ID', serialize=False, auto_created=True, primary_key=True)),
                ('permission', models.ForeignKey(to='my_admin.AuthPermission')),
                ('user', models.ForeignKey(to='my_admin.AuthUser')),
            ],
            options={
                'db_table': 'auth_user_user_permissions',
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
            },
        ),
        migrations.CreateModel(
            name='Desk',
            fields=[
                ('desk_num', models.IntegerField(serialize=False, primary_key=True)),
            ],
            options={
                'db_table': 'desk',
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
            },
        ),
        migrations.CreateModel(
            name='Menuitem',
            fields=[
                ('menuitem_id', models.AutoField(serialize=False, primary_key=True)),
                ('menuitem_bigsale', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('menuitem_status', models.IntegerField(null=True, blank=True)),
                ('menuitem_category', models.ForeignKey(to='my_admin.Category', db_column='menuitem_category')),
                ('menuitem_food', models.ForeignKey(db_column='menuitem_food', blank=True, to='my_admin.Food', null=True)),
            ],
            options={
                'db_table': 'menuitem',
            },
        ),
        migrations.CreateModel(
            name='Order',
            fields=[
                ('order_id', models.AutoField(serialize=False, primary_key=True)),
                ('order_code', models.CharField(max_length=40, null=True, blank=True)),
                ('order_generatedate', models.CharField(max_length=50, null=True, blank=True)),
                ('order_finishdate', models.CharField(max_length=50, null=True, blank=True)),
                ('order_state', models.TextField(null=True, blank=True)),
                ('order_mermoney', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('order_commoney', models.DecimalField(null=True, max_digits=7, decimal_places=2, blank=True)),
                ('order_deskid', models.IntegerField(null=True, db_column='order_deskId', blank=True)),
                ('order_personnum', models.IntegerField(null=True, db_column='order_personNum', blank=True)),
                ('order_issent', models.TextField(null=True, db_column='order_isSent', blank=True)),
                ('order_iswaiterconfirm', models.TextField(null=True, db_column='order_isWaiterConfirm', blank=True)),
                ('order_ishumanpay', models.TextField(null=True, db_column='order_isHumanPay', blank=True)),
            ],
            options={
                'db_table': 'order',
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
                ('orderitem_food', models.ForeignKey(to='my_admin.Food', db_column='orderitem_food')),
                ('orderitem_order', models.ForeignKey(to='my_admin.Order', db_column='orderitem_order')),
            ],
            options={
                'db_table': 'orderitem',
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
                ('special_food', models.ForeignKey(to='my_admin.Food', db_column='special_food')),
            ],
            options={
                'db_table': 'special',
            },
        ),
        migrations.CreateModel(
            name='User',
            fields=[
                ('user_id', models.AutoField(serialize=False, primary_key=True)),
                ('user_name', models.CharField(max_length=40, null=True, blank=True)),
                ('user_account', models.CharField(max_length=40, null=True, blank=True)),
                ('user_passwd', models.CharField(max_length=40, null=True, blank=True)),
                ('user_role', models.ForeignKey(db_column='user_role', blank=True, to='my_admin.Role', null=True)),
            ],
            options={
                'db_table': 'user',
            },
        ),
        migrations.AddField(
            model_name='order',
            name='order_pay',
            field=models.ForeignKey(db_column='order_pay', blank=True, to='my_admin.Pay', null=True),
        ),
        migrations.AddField(
            model_name='order',
            name='order_user',
            field=models.ForeignKey(db_column='order_user', blank=True, to='my_admin.User', null=True),
        ),
        migrations.AddField(
            model_name='mac',
            name='mac_order',
            field=models.ForeignKey(db_column='mac_order', blank=True, to='my_admin.Order', null=True),
        ),
        migrations.AddField(
            model_name='evaluate',
            name='dishid',
            field=models.ForeignKey(db_column='dishId', blank=True, to='my_admin.Food', null=True),
        ),
        migrations.AddField(
            model_name='djangoadminlog',
            name='content_type',
            field=models.ForeignKey(blank=True, to='my_admin.DjangoContentType', null=True),
        ),
        migrations.AddField(
            model_name='djangoadminlog',
            name='user',
            field=models.ForeignKey(to='my_admin.AuthUser'),
        ),
        migrations.AddField(
            model_name='authpermission',
            name='content_type',
            field=models.ForeignKey(to='my_admin.DjangoContentType'),
        ),
        migrations.AddField(
            model_name='authgrouppermissions',
            name='permission',
            field=models.ForeignKey(to='my_admin.AuthPermission'),
        ),
        migrations.AddField(
            model_name='agent',
            name='agent_order',
            field=models.ForeignKey(to='my_admin.Order', db_column='agent_order'),
        ),
    ]
