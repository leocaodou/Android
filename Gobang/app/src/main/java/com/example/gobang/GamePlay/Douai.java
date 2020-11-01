package com.example.gobang.GamePlay;

import android.graphics.Point;
import android.view.PointerIcon;

public class Douai {
    private static int Black = -1;
    private static int White = 1;
    private static int Depth = 2;
    private static int Infinite = 10000000;
    private Table T = new Table();
    public int score(int Who)
    {
        int sum = 0;
        for(int i = 0; i < 15;i++)
        {
            for(int j = 0; j <= 9;j++)
            {
                int w = 1;
                int p = 0, q = 0;
                for(int k = j;k < j + 6;k++)
                {
                    if(T.getGoType(i,k) == Who)
                        p++;
                    else if(T.bord[i][k] == -Who)
                        q++;
                }
                if(p == 0)
                    continue;
                if(q == 0)
                {
                    switch(p)
                    {
                        case 4:
                            if(T.bord[i][j] != Who && T.bord[i][j+5] != Who)
                            {
                                sum += 4320;
                                w = 0;
                            }
                            break;
                        case 3:
                            if(T.bord[i][j] != Who && T.bord[i][j+5] != Who)
                            {
                                sum += 720;
                                w = 0;
                            }
                            break;
                        case 2:
                            if(T.bord[i][j] != Who && T.bord[i][j+5] != Who)
                            {
                                sum += 120;
                                w = 0;
                            }
                            break;
                        case 1:
                            if(T.bord[i][j+3] == Who || T.bord[i][j+2] == Who)
                            {
                                sum += 20;
                                w = 0;
                            }
                            break;
                    }
                }
                if(w == 0)
                    continue;
                for(int l = 0;l < 2;l++)
                {
                    p = 0;
                    q = 0;
                    for(int k = j + l;k < j + l + 5;k++)
                    {
                        if(T.bord[i][k] == Who)
                            p++;
                        else if(T.bord[i][k] == -Who)
                            q++;
                    }
                    if(p == 0)
                        continue;
                    if(q == 0)
                    {
                        switch(p)
                        {
                            case 5:
                                sum += 50000;
                                w = 0;
                                break;
                            case 4:
                                sum += 720;
                                w = 0;
                                break;
                        }
                    }
                }
            }
        }
//	cout << sum <<endl;
        for(int i = 0; i < 15;i++)
        {
            for(int j = 0; j <= 9;j++)
            {
                int w = 1;
                int p = 0, q = 0;
                for(int k = j;k < j + 6;k++)
                {
                    if(T.bord[k][i] == Who)
                        p++;
                    else if(T.bord[k][i] == -Who)
                        q++;
                }
                if(p == 0)
                    continue;
                if(q == 0)
                {
                    switch(p)
                    {
                        case 4:
                            if(T.bord[j][i] != Who && T.bord[j+5][i] != Who)
                            {
                                sum += 4320;
                                w = 0;
                            }
                            break;
                        case 3:
                            if(T.bord[j][i] != Who && T.bord[j+5][i] != Who)
                            {
                                sum += 720;
                                w = 0;
                            }
                            break;
                        case 2:
                            if(T.bord[j][i] != Who && T.bord[j+5][i] != Who)
                            {
                                sum += 120;
                                w = 0;
                            }
                            break;
                        case 1:
                            if(T.bord[j+3][i] == Who ||T.bord[j+2][i] == Who)
                            {
                                sum += 20;
                                w = 0;
                            }
                            break;
                    }
                }
                if(w == 0)
                    continue;
                for(int l = 0;l < 2;l++)
                {
                    p = 0;
                    q = 0;
                    for(int k = j + l;k < j + l + 5;k++)
                    {
                        if(T.bord[k][i] == Who)
                            p++;
                        else if(T.bord[k][i] == -Who)
                            q++;
                    }
                    if(p == 0)
                        continue;
                    if(q == 0)
                    {
                        switch(p)
                        {
                            case 5:
                                sum += 50000;
                                w = 0;
                                break;
                            case 4:
                                sum += 720;
                                w = 0;
                                break;
                        }
                    }
                }
            }
        }
//	cout << sum <<endl;
        for(int i = 0; i < 19;i++)
        {
            if(i < 10)
            {
                for(int j = 0; j <= i;j++)
                {
                    int w = 1;
                    int p = 0, q = 0;
                    for(int k = 0;k < 6;k++)
                    {
                        if(T.bord[i+5-j-k][j+k] == Who)
                            p++;
                        else if(T.bord[i+5-j-k][j+k] == -Who)
                            q++;
                    }
                    if(p == 0)
                        continue;
                    if(q == 0)
                    {
                        switch(p)
                        {
                            case 4:
                                if(T.bord[i+5-j][j] != Who && T.bord[i-j][j+5] != Who)
                                {
                                    sum += 4320;
                                    w = 0;
                                }
                                break;
                            case 3:
                                if(T.bord[i+5-j][j] != Who && T.bord[i-j][j+5] != Who)
                                {
                                    sum += 720;
                                    w = 0;
                                }
                                break;
                            case 2:
                                if(T.bord[i+5-j][j] != Who && T.bord[i-j][j+5] != Who)
                                {
                                    sum += 120;
                                    w = 0;
                                }
                                break;
                            case 1:
                                if(T.bord[i+2-j][j+3] == Who || T.bord[i+3-j][j+2] == Who)
                                {
                                    sum += 20;
                                    w = 0;
                                }
                                break;
                        }
                    }
                    if(w == 0)
                        continue;
                    for(int l = 0;l < 2;l++)
                    {
                        p = 0;
                        q = 0;
                        for(int k = l;k < l + 5;k++)
                        {
                            if(T.bord[i+5-j-k][j+k] == Who)
                                p++;
                            else if(T.bord[i+5-j-k][j+k] == -Who)
                                q++;
                        }
                        if(p == 0)
                            continue;
                        if(q == 0)
                        {
                            switch(p)
                            {
                                case 5:
                                    sum += 50000;
                                    w = 0;
                                    break;
                                case 4:
                                    sum += 720;
                                    w = 0;
                                    break;
                            }
                        }
                    }
                }
            }
            else
            {
                for(int j = 0; j <= 18-i;j++)
                {
                    int w = 1;
                    int p = 0, q = 0;
                    for(int k = 0;k < 6;k++)
                    {
                        if(T.bord[14-k-j][i-9+k+j] == Who)
                            p++;
                        else if(T.bord[14-k-j][i-9+k+j] == -Who)
                            q++;
                    }
                    if(p == 0)
                        continue;
                    if(q == 0)
                    {
                        switch(p)
                        {
                            case 4:
                                if(T.bord[14-j][i-9+j] != Who && T.bord[9-j][i-4+j] != Who)
                                {
                                    sum += 4320;
                                    w = 0;
                                }
                                break;
                            case 3:
                                if(T.bord[14-j][i-9+j] != Who && T.bord[9-j][i-4+j] != Who)
                                {
                                    sum += 720;
                                    w = 0;
                                }
                                break;
                            case 2:
                                if(T.bord[14-j][i-9+j] != Who && T.bord[9-j][i-4+j] != Who)
                                {
                                    sum += 120;
                                    w = 0;
                                }
                                break;
                            case 1:
                                if(T.bord[12-j][i-7+j] == Who || T.bord[11-j][i-6+j] == Who)
                                {
                                    sum += 20;
                                    w = 0;
                                }
                                break;
                        }
                    }
                    if(w == 0)
                        continue;
                    for(int l = 0;l < 2;l++)
                    {
                        p = 0;
                        q = 0;
                        for(int k = j + l;k < j + l + 5;k++)
                        {
                            if(T.bord[14 - k][i-9+k] == Who)
                                p++;
                            else if(T.bord[14 - k][i-9+k] == -Who)
                                q++;
                        }
                        if(p == 0)
                            continue;
                        if(q == 0)
                        {
                            switch(p)
                            {
                                case 5:
                                    sum += 50000;
                                    w = 0;
                                    break;
                                case 4:
                                    sum += 720;
                                    w = 0;
                                    break;
                            }
                        }
                    }
                }
            }
        }
//	cout << sum <<endl;
        for(int i = 0; i < 19;i++)
        {
            if(i < 10)
            {
                for(int j = 0; j <= i;j++)
                {
                    int w = 1;
                    int p = 0, q = 0;
                    for(int k = j;k < j + 6;k++)
                    {
                        if(T.bord[i+5-k][14-k] == Who)
                            p++;
                        else if(T.bord[i+5-k][14-k] == -Who)
                            q++;
                    }
                    if(p == 0)
                        continue;
                    if(q == 0)
                    {
                        switch(p)
                        {
                            case 4:
                                if(T.bord[i+5-j][14-j] != Who && T.bord[i-j][9-j] != Who)
                                {
                                    sum += 4320;
                                    w = 0;
                                }
                                break;
                            case 3:
                                if(T.bord[i+5-j][14-j] != Who && T.bord[i-j][9-j] != Who)
                                {
                                    sum += 720;
                                    w = 0;
                                }
                                break;
                            case 2:
                                if(T.bord[i+5-j][14-j] != Who && T.bord[i-j][9-j] != Who)
                                {
                                    sum += 120;
                                    w = 0;
                                }
                                break;
                            case 1:
                                if(T.bord[i+3-j][12-j] == Who || T.bord[i+2-j][11-j] == Who)
                                {
                                    sum += 20;
                                    w = 0;
                                }
                                break;
                        }
                    }
                    if(w == 0)
                        continue;
                    for(int l = 0;l < 2;l++)
                    {
                        p = 0;
                        q = 0;
                        for(int k = j + l;k < j + l + 5;k++)
                        {
                            if(T.bord[i+5-k][14-k] == Who)
                                p++;
                            else if(T.bord[i+5-k][14-k] == -Who)
                                q++;
                        }
                        if(p == 0)
                            continue;
                        if(q == 0)
                        {
                            switch(p)
                            {
                                case 5:
                                    sum += 50000;
                                    w = 0;
                                    break;
                                case 4:
                                    sum += 720;
                                    w = 0;
                                    break;
                            }
                        }
                    }
                }
            }
            else
            {
                for(int j = 0; j <= 18-i;j++)
                {
                    int w = 1;
                    int p = 0, q = 0;
                    for(int k = j;k < j + 6;k++)
                    {
                        if(T.bord[14 - k][23-i-k] == Who)
                            p++;
                        else if(T.bord[14 - k][23-i-k] == -Who)
                            q++;
                    }
                    if(p == 0)
                        continue;
                    if(q == 0)
                    {
                        switch(p)
                        {
                            case 4:
                                if(T.bord[14-j][23-i-j] != Who && T.bord[9-j][18-i-j] != Who)
                                {
                                    sum += 4320;
                                    w = 0;
                                }
                                break;
                            case 3:
                                if(T.bord[14-j][23-i-j] != Who && T.bord[9-j][18-i-j] != Who)
                                {
                                    sum += 720;
                                    w = 0;
                                }
                                break;
                            case 2:
                                if(T.bord[14-j][23-i-j] != Who && T.bord[9-j][18-i-j] != Who)
                                {
                                    sum += 120;
                                    w = 0;
                                }
                                break;
                            case 1:
                                if(T.bord[12-j][21-i-j] == Who || T.bord[11-j][20-i-j] == Who)
                                {
                                    sum += 20;
                                    w = 0;
                                }
                                break;
                        }
                    }
                    if(w == 0)
                        continue;
                    for(int l = 0;l < 2;l++)
                    {
                        p = 0;
                        q = 0;
                        for(int k = j + l;k < j + l + 5;k++)
                        {
                            if(T.bord[14 - k][14-i+9-k] == Who)
                                p++;
                            else if(T.bord[14 - k][14-i+9-k] == -Who)
                                q++;
                        }
                        if(p == 0)
                            continue;
                        if(q == 0)
                        {
                            switch(p)
                            {
                                case 5:
                                    sum += 50000;
                                    w = 0;
                                    break;
                                case 4:
                                    sum += 720;
                                    w = 0;
                                    break;
                            }
                        }
                    }
                }
            }
        }
//	cout << sum <<endl;
        int p = 0, q = 0;
        for(int i = 0;i < 5;i++)
        {
            if(T.bord[4-i][i] == Who)
                p++;
            else if(T.bord[4-i][i] == -Who)
                q++;
            if(q != 0||p == 0)
                break;
            if(p == 5)
                sum += 50000;
            else if(p == 4)
                sum += 720;
        }
        p = 0;
        q = 0;
        for(int i = 0;i < 5;i++)
        {
            if(T.bord[14-i][10 + i] == Who)
                p++;
            else if(T.bord[14-i][10 + i] == -Who)
                q++;
            if(q != 0||p == 0)
                break;
            if(p == 5)
                sum += 50000;
            else if(p == 4)
                sum += 720;
        }
        p = 0;
        q = 0;
        for(int i = 0;i < 5;i++)
        {
            if(T.bord[4-i][14-i] == Who)
                p++;
            else if(T.bord[4-i][14-i] == -Who)
                q++;
            if(q != 0||p == 0)
                break;
            if(p == 5)
                sum += 50000;
            else if(p == 4)
                sum += 720;
        }
        p = 0;
        q = 0;
        for(int i = 0;i < 5;i++)
        {
            if(T.bord[4-i][i] == Who)
                p++;
            else if(T.bord[4-i][i] == -Who)
                q++;
            if(q != 0||p == 0)
                break;
            if(p == 5)
                sum += 50000;
            else if(p == 4)
                sum += 720;
        }
//	show(T);
//	system("cls");
        return sum;
    }
    void Player(int x,int y)
    {
        Position p = new Position(x,y);
        T.add(p,White);
    }
    int MaxMin(int who,int depth,int alpha,int beta)
    {
        int i = T.getLastX() - 4;
        int j = T.getLastY() - 4;
        int k = 0,l = 0;
        if(depth == Depth)
        {
            return score(Black) - score(White);
        }
        else
        {
            if(who == White)
            {
                int min = Infinite;
                while(true)
                {
                    if(i+l >= 0 && i+l < 15 && j + k >= 0 && j + k < 15 && T.empty(i+l,j + k))
                    {
                        T.add2(i+l,j + k,White);
                        int v;
                        v = MaxMin(Black,depth + 1,alpha,beta);
                        if(min > v)
                        {
                            min = v;
                        }
                        T.DeleteP(i+l,j+k);
                        if(beta > v)
                        {
                            beta = v;
                        }
                        if(alpha >= beta)
                            return min;
                    }
                    k++;
                    if(k == 9)
                    {
                        l++;
                        k = 0;
                    }
                    if(l == 9 || i+l >= 15)
                        break;
                }
                return min;
            }
            else
            {
                int max = -Infinite;
                while(true)
                {
                    if(i+l >= 0 && i+l < 15 && j + k >= 0 && j + k < 15 && T.empty(i+l,j + k))
                    {
                        T.add2(i+l,j + k,Black);
                        int v;
                        v = MaxMin(White,depth + 1,alpha,beta);
                        if(max < v)
                        {
                            max = v;
                        }
                        T.DeleteP(i+l,j+k);
                        if(alpha < v)
                        {
                            alpha = v;
                        }
                        if(alpha >= beta)
                            return max;
                    }
                    k++;
                    if(k == 9)
                    {
                        l++;
                        k = 0;
                    }
                    if(l == 9 || i+l >= 15)
                        break;
                }
                return max;
            }
        }
    }
    public boolean GameOver()
    {
        int x = T.getLastX();
        int y = T.getLastY();
        int who = T.getLast();
        int u=0,d=0,l=0,r=0,lu=0,ld=0,ru=0,rd=0;
        int i = 1;
        while(x + i  <= 14 && T.bord[x+i][y] == who)
        {
            d++;
            i++;
        }
        i = 1;
        while(x + i  <= 14 && y + i  <= 14 && T.bord[x+i][y+i] == who)
        {
            rd++;
            i++;
        }
        i = 1;
        while(x + i  <= 14 && T.bord[x+i][y-i] == who)
        {
            ld++;
            i++;
        }
        i = 1;
        while(x - i  >= 0 && T.bord[x-i][y] == who)
        {
            u++;
            i++;
        }
        i = 1;
        while(x - i  >= 0 && y + i  <= 14 && T.bord[x-i][y+i] == who)
        {
            ru++;
            i++;
        }
        i = 1;
        while(x - i  >= 0 && y - i  >= 0 && T.bord[x-i][y-i] == who)
        {
            lu++;
            i++;
        }
        i = 1;
        while( y - i  >= 0 && T.bord[x][y-i] == who)
        {
            l++;
            i++;
        }
        i = 1;
        while(y + i  <= 14 && T.bord[x][y+i] == who)
        {
            r++;
            i++;
        }
        if((u+d+1>=5) ||(l+r+1>=5) || (lu+rd+1>=5) || (ru+ld+1>=5))
            return true;
        else
            return false;
    }
    public Point setGo()
    {
        int i = T.getLastX() - 4;
        int j = T.getLastY() - 4;
        int k = 0,l = 0;
        int x = -1,y = -1,max = -Infinite;
        while(true)
        {
            if(i+l >= 0 && i+l < 15 && j + k >= 0 && j + k < 15 && T.empty(i+l,j + k))
            {
                T.add2(i+l,j+k,Black);
                int v;
                int alpha = -Infinite;
                int beta = Infinite;
                v = MaxMin(White, 1,alpha,beta);
//			cout << i+l+1 << ' '<< j+k+1 << ' ' << v << endl;
                if(max < v)
                {
                    max = v;
                    x = i + l;
                    y = j + k;
                }

                T.DeleteP(i+l,j+k);
            }
            k++;
            if(k == 9)
            {
                l++;
                k = 0;
            }
            if(l == 9 || i+l >= 15)
                break;
        }
        T.add2(x,y,Black);
        return new Point(x+1,y+1);
    }
    public void back(){
        T.Back();
        T.Back();
    }
}
